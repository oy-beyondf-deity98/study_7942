package deity.frame.first.admin.code;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import deity.frame.first.common.SearchVo;
import deity.frame.first.domain.Code;

@Repository
public class CodeRepository implements CodeDAO {

	@Autowired SqlSession sqlSession;
	
	@Override
	public List<Code> list(SearchVo search) {
		search.pagingInit();
		int listCount = sqlSession.selectOne("listCodeCnt", search);
		search.setTotRow(listCount);

		return sqlSession.selectList("listCode", search);
		
	}

	@Override
	public Code get(String code) {
		
		return sqlSession.selectOne("getCode",code);
	}

	@Override
	public int insert(Code code) {
		
		return sqlSession.insert("insertCode",code);
	}

	@Override
	public int update(Code code) {
		
		return sqlSession.update("updateCode",code);
	}

	@Override
	public int delete(String id) {
		return sqlSession.delete("deleteCode",id);
	}

	@Override
	public Map<String,String> ableDeleteCode(String code) {
		return sqlSession.selectOne("ableDeleteCode",code);
	}


}
