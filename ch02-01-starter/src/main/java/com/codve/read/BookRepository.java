package com.codve.read;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 使用 JpaRepository, 可以直接继承 18 个常用的增删改查作方法
 * JpaRepository 是泛型接口, 第一个参数表示领域对象, 第二个参数表示主键
 * 还可以增加自己的方法, 比如 findByReader
 * Spring Data JPA会自动实现即可的方法
 * @author admin
 * @date 2019/10/26 11:53
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);
}
