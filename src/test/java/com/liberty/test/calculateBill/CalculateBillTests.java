package com.liberty.test.calculateBill;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.liberty.test.service.Customer;
import com.liberty.test.service.Item;

public class CalculateBillTests {

	public Customer customer;

	/**
	 * Making sure the paramters are reset before each test case
	 */
	@Before
	public void setUp() {
		customer = new Customer();

		List<Item> itemList = new ArrayList<>();
		Item snacks = Mockito.mock(Item.class);
		Item drinks = Mockito.mock(Item.class);
		Item vegetables = Mockito.mock(Item.class);
		Item grocery = Mockito.mock(Item.class);

		when(snacks.getName()).thenReturn("Lays");
		when(drinks.getName()).thenReturn("Coke");
		when(vegetables.getName()).thenReturn("Tomato");
		when(grocery.getName()).thenReturn("Cake Mix");

		when(snacks.getPrice("Lays")).thenReturn(4);
		when(drinks.getPrice("Coke")).thenReturn(6);
		when(vegetables.getPrice("Tomato")).thenReturn(3);
		when(grocery.getPrice("Cake Mix")).thenReturn(5);

		itemList.add(snacks);
		itemList.add(drinks);
		itemList.add(vegetables);
		itemList.add(grocery);

		customer.setListOfItems(itemList);

	}

	/**
	 * Testing the size of Items mocked.
	 */
	@Test
	public void itemListSizeTest() {
		{
			Assert.assertEquals(4, customer.getListOfItems().size());
		}
	}

	/**
	 * Testing the Item Price based on Names.
	 */
	@Test
	public void itemListPricesBasedOnNameTest() {
		{
			Assert.assertEquals(4, customer.getListOfItems().get(0).getPrice("Lays"));
			Assert.assertEquals(6, customer.getListOfItems().get(1).getPrice("Coke"));
			Assert.assertEquals(3, customer.getListOfItems().get(2).getPrice("Tomato"));
			Assert.assertEquals(5, customer.getListOfItems().get(3).getPrice("Cake Mix"));
		}
	}

	/**
	 * Testing the total cost of Items that are purchased.
	 */
	@Test
	public void calculateBillTest() {
		{
			Assert.assertEquals(18, customer.calculateBill());
		}
	}

}
