package com.tokeninc.playground.data


class Category(val name: String, vararg item: Item) {

    val listOfItems: List<Item> = item.toList()

}