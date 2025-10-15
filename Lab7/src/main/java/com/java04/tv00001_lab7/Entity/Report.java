package com.java04.tv00001_lab7.Entity;

import java.io.Serializable;

public interface Report {
    Serializable getGroup();  // Category
    Double getSum();
    Long getCount();
}