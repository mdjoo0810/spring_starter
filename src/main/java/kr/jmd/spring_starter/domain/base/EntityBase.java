package kr.jmd.spring_starter.domain.base;

import lombok.Getter;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class EntityBase<T extends EntityBase<T>> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    /**
     * Entity ID 비교
     *
     * @param that - 같은 타입의 다른 entity
     *
     * @return 다은 속성에 관계 없이 Id가 동일하면 true 를 반환함.
     *
     * @throws IllegalStateException - 엔티티 중 하나의 ID 속정이 설정되지 않음.
     */
    public boolean sameIdentityAs(final T that) {
        return this.equals(that);
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof EntityBase)) {
            return false;
        }

        final EntityBase<?> that = (EntityBase<?>) object;

        _checkIdentity(this);
        _checkIdentity(that);

        return this.id.equals(that.getId());
    }

    /**
     *
     * @param entity - 검증할 entity
     *
     * @throws IllegalStateException - 엔티티의 ID 속정이 설정되지 않음.
     */
    private void _checkIdentity(final EntityBase<?> entity) {
        if (entity.getId() == null) {
            throw new IllegalStateException("Identity missing in entity" + entity);
        }
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
