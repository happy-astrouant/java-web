package com.xzy.web01.entity;

import java.util.List;

public class PageResult <T>{
    private Long total;
    private List<T> rows;
}
