package com.github.zouzhberk.dbstudy.deadlock;

/**
 * Created by berk (zouzhberk@163.com)) on 8/29/16.
 */
public class StockPriceEntity
{
    private Long id;
    private Long stockId;
    private Double close;
    private Long date;
    private String name;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getStockId()
    {
        return stockId;
    }

    public void setStockId(Long stockId)
    {
        this.stockId = stockId;
    }

    public Double getClose()
    {
        return close;
    }

    public void setClose(Double close)
    {
        this.close = close;
    }

    public Long getDate()
    {
        return date;
    }

    public void setDate(Long date)
    {
        this.date = date;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
