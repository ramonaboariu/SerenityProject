package com.emag.steps;

import com.emag.pages.CartPage;
import com.emag.pages.EmagHomePage;
import com.emag.pages.ProductViewPage;
import com.emag.pages.SearchResultsListPage;

import net.thucydides.core.annotations.Step;

public class EmagSteps {

    EmagHomePage emagHomePage;
    SearchResultsListPage searchResultsList;
    SearchResultsListPage searchProductList;
    ProductViewPage addToCartProduct;
    CartPage cart;

    @Step
    public void navigateTo(String url) {
        emagHomePage.navigateTo(url);
    }

    @Step
    public void searchTerm(String keyword) {

        emagHomePage.inputSearchTerm(keyword);
    }

    @Step
    public void navigateToRandomResultsPage(String keyword) {

        searchResultsList.redirectToRandomProductsList(keyword);
    }

    @Step
    public void getRandomProduct() {

        searchProductList.getRandomProduct();
    }

    @Step
    public void addToCart() {
        addToCartProduct.addToCart();
    }

    @Step
    public void cartProducts(){
        cart.getProductsFromCart();
    }

}

