package io.github.ertansidar.response;

import io.github.ertansidar.paging.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListResponse {
    public static <T, R, ID extends Serializable> GetListResponse<R> get(
            PageInfo pageInfo,
            JpaRepository<T, ID> repository,
            Function<T, R> mapper) {

        GetListResponse<R> response = new GetListResponse<>();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize());
        Page<T> entities = repository.findAll(pageable);

        response.setItems(entities.stream().map(mapper).collect(Collectors.toList()));
        response.setTotalElements(entities.getTotalElements());
        response.setTotalPage(entities.getTotalPages());
        response.setSize(entities.getSize());
        response.setHasNext(entities.hasNext());
        response.setHasPrevious(entities.hasPrevious());

        return response;
    }
}
