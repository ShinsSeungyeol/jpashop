package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {
    private  ItemService itemService;

    @Test
    void saveItem() {
//        Item item = new Item();


    }

    @Test
    void findItems() {
    }

    @Test
    void findOne() {
    }
}