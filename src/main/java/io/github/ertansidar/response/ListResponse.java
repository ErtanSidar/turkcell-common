package io.github.ertansidar.response;

import io.github.ertansidar.paging.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.function.Function;

public class ListResponse {
    public static <T, R, ID extends Serializable> GetListResponse<R> get(
            PageInfo pageInfo,
            PagingAndSortingRepository<T, ID> repository,
            Function<T, R> mapper) {

        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<T> pageResult = repository.findAll(pageable);

        return buildResponse(pageResult, mapper);
    }

    private static <T, R> GetListResponse<R> buildResponse(Page<T> page, Function<T, R> mapper) {
        GetListResponse<R> response = new GetListResponse<>();
        response.setItems(page.stream().map(mapper).toList());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPage(page.getTotalPages());
        response.setSize(page.getSize());
        response.setHasNext(page.hasNext());
        response.setHasPrevious(page.hasPrevious());
        return response;
    }
}
