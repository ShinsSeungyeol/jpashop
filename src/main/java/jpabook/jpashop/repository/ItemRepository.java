package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            // 병합 방법
            Item mergeItem = em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}


/**
 * 변경 감지와 병합(merge)
 * 참고 : 정말 중요한 내용
 *
 * 준영속 엔티티
 * - 영속성 컨텍스트가 더는 관리하지 않는 엔티티를 말한다.
 * - 임의로 만들어낸 엔티티도 기존 식별자를 가지고 있으면 준영속 엔티로 볼 수 있다.
 *
 * 준영속 엔티티를 수정하는 2가지 방법
 * - 변경 감지 기능 사용
 * - 병합(merge) 사용 - 준영속 상태를 영속 상태로 만드는 것이다.
 *
 * 병합을 사용하면 모든 속성이 변경된다. (실무에서 굉장히 위험함)
 * 병합시 값이 없으면 NULL 업데이트를 해버림
 */