package jpabook.jpashop.service;

import jpabook.jpashop.controller.UpdateItemDto;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // 권장하는 방법 - 변경감지 기능 사용
    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item findItem = itemRepository.findOne(itemId);
        // 업데이트는 의미있는 함수로 만들어서 바꿈, findItem.change(price, name)
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);
    }

    @Transactional
    public void updateItemByDto(UpdateItemDto updateItemDto) {
        Item findItem = itemRepository.findOne(updateItemDto.getItemId());

        findItem.setStockQuantity(updateItemDto.getStockQuantity());
        findItem.setName(updateItemDto.getName());
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
