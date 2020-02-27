package com.chuno.found.dao;


import net.bytebuddy.TypeCache;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoundRepository extends JpaRepository<Found, Long> {


   List<Found> findByFoundTitle(String foundTitle);
   List<Found> findByMemId(String memId);
   List<Found> findByMemIdAndFoundId(String memId, long foundId);


   @Query("SELECT f FROM Found as f where f.foundTitle=?1") //?1 -> 이건 채번한거다
   List<Found> myTest(String found_title, Sort sort); //sort는 그 안에서 사용하는 프로퍼티 또는 alias가 엔터티에 없는 경우에 예외 발생!

   @Query("SELECT f FROM #{#entityName} as f where f.foundTitle= :foundTitle") // #{#entityName} -> Found를 찾아감. 장점은 found에서 entity 이름정의한경우 좋음
   List<Found> myTest2(@Param("foundTitle") String foundTitle, Sort sort);


   //update query를 만들어보자.
   //성능상에 이유라던가 무튼 정의해서 쓸수 있긴하다. -> 안쓰는걸 권장
   @Modifying(clearAutomatically = true)
   @Query("UPDATE Found f Set f.categoryName = ?1 WHERE f.foundId =?2")
   int updateCategoryName(String categoryName, String foundId);
}
