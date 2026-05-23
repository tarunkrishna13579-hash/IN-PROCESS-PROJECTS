package com.FoodDelivery.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.FoodDelivery.Restaurants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.FoodDelivery.MenuItems;
import com.FoodDelivery.CustomerRepository.RestaurantsRepository;
import com.FoodDelivery.CustomerRepository.menuItemRepository;




@RestController
public class menuItemController {
	@Autowired
	menuItemRepository menurepo;
	
	@Autowired
	RestaurantsRepository resrepo;

	@GetMapping("/menu/all")
	public List<MenuItems> getAll(){
	    return menurepo.findAll();
	}
	
	@GetMapping("/restaurants/{id}/menu")
    public ResponseEntity<?> getMenu(@PathVariable Integer id){
        List<MenuItems> items =menurepo.getMenuByRestaurant_id(id);
        
        Map<String,Object>mp=new HashMap<>();
        mp.put("fetched all menu items related to restaurant", items);
        return ResponseEntity.ok(mp);
    }
	
	@PostMapping("/addmenu/{id}/create")
	public ResponseEntity<?>createMenu(@PathVariable int id,@RequestBody MenuItems menuitems){
		
		Restaurants restaurant = resrepo.findById(id).get();
		menuitems.setRestaurant_id(restaurant);
		MenuItems saved=menurepo.save(menuitems);
		
		 Map<String,Object> mp = new HashMap<>();
		    mp.put("Menu Item Added", saved);
		    return ResponseEntity.ok(mp);
	}
	
	@PutMapping("/updatemenu/{restid}/{itemid}")
	public ResponseEntity<?>updatemenu(@PathVariable int restid, @PathVariable int itemid,@RequestBody MenuItems menuitems){
		Optional<MenuItems> optionalItem =menurepo.findById(itemid);

//        // item not found
//        if (optionalItem.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }

        MenuItems item = optionalItem.get();

//        // check item belongs to restaurant
//        if (!item.getRestaurant_id().equals(restid)) {
//            return ResponseEntity.badRequest().build();
//        }

        // update values
        item.setItem_name(menuitems.getItem_name());
        item.setItem_price(menuitems.getItem_price());
        item.setItem_description(menuitems.getItem_description());

        // save updated item
        MenuItems savedItem = menurepo.save(item);
        Map<String,Object>mp=new HashMap<>();
        mp.put("Updated the item",savedItem);
        return ResponseEntity.ok(mp);
    }
	
	@DeleteMapping("/delete/{rest_id}/{item_id}")
	public String deletemenuitem(@PathVariable int item_id,@PathVariable int rest_id){
		MenuItems item = menurepo.findById(item_id).get();
		menurepo.deleteOrderItems(item_id);
		menurepo.delete(item);
		 return "Menu item deleted successfully";
	}
}

