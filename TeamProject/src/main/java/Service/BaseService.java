package Service;

import java.util.List;

import com.alohaclass.jdbc.dto.PageInfo;

public interface BaseService<T> {
	List<T> list();                                     // 전체 리스트
    PageInfo<T> getPageList(int page, int pageSize);    // 페이징 리스트 (page: 페이지 번호, pageSize: 페이지당 데이터 수)
    T select(Long no);                                  // no(PK) 조회
    T selectById(String id);                            // id(PK) 조회
    boolean create(T entity);                           // 생성
    boolean update(T entity);                           // 수정
    boolean updateById(T entity, String id);            // id(PK) 수정
    boolean delete(Long no);                            // no(PK) 삭제
    boolean deleteById(String id);                      // id(PK) 삭제
	boolean isUserIdDuplicate(String userId);			// id 중복체크
}
