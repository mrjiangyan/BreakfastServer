package com.beyondh.breakfast.network.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jliang on 7/31/2017.
 */
public class PmsPageModel<T> {

    public Integer getPageCount() {
        if (pageSize < 1)
        {
            pageSize = 5;
        }
        pageCount = recordCount / pageSize;
        Integer tmpValue = recordCount % pageSize;

        if (tmpValue == 0)
        {
            return pageCount;
        }
        pageCount++;
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    @JsonProperty("PageCount")
    private Integer pageCount;

    @JsonProperty("PageSize")
    private Integer pageSize;

    @JsonProperty("PageIndex")
    private Integer pageIndex;

    @JsonProperty("RecordCount")
    private Integer recordCount;

    @JsonProperty("Content")
    private List<T> content;
}
