package designpatterns;

import models.Stock;

public interface Observer {
    void update(Stock stock);
}