package common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StopWatch;

public class DaoService extends SqlSessionDaoSupport{

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired(required=true)
	@Qualifier("sqlSession")
	private SqlSession sqlSession;
	
	/**
	 * 직접 SQL session을 호출하기 위해서 필요
	 * 보통은 밑에 있는 클래스를 쓰도록 하자.
	 * @return
	 */
	public SqlSession getSqlManager() {
		return sqlSession;
	}
	
	public <T> T selectOne(String statement) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        T obj = getSqlManager().selectOne(statement);
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement);
        return obj;
    }
    public <T> T selectOne(String statement, Object p) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        T obj = getSqlManager().selectOne(statement,p);
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement);
        return obj;
    }

    public <E> List<E> selectList(String statement) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        List<E> result = getSqlManager().selectList(statement);
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement);
        return result;
    }
    
    public <E> List<E> selectList(String statement, Object obj) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        List<E> result = getSqlManager().selectList(statement,obj);
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement);
        return result;
    }
    
    public <E> List<E> selectList_checkNotfound(String statement, Object obj) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        List<E> result = getSqlManager().selectList(statement,obj);
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement);
        return result;
    }    
    
    /*************************************                      ORI-INSERT                      ************************************/
    public int insert(String statement) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int result = getSqlManager().insert(statement);
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement);
        return result;
    }
    public int insert(String statement, Object object) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int result = getSqlManager().insert(statement, object);
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement);
        return result;
    }
    
    /*************************************                  ORI-DELETE                          ************************************/
    public int delete(String statement, Object object) {
        int deleteCount = 0;
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            deleteCount = getSqlManager().delete(statement, object);
            stopWatch.stop();
            loggingElapsedTime(stopWatch, statement);
        } catch (RuntimeException e) {
            throw e;
        }
        return deleteCount;
    }

    public int delete(String statement) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int result = getSqlManager().delete(statement);
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement);
        return result;
    }
    
    
    
    /*************************************                  ORI-UPDATE                          ************************************/

    public int update(String statement) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int result = getSqlManager().update(statement);
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement);
        return result;
    }
    
    public int update(String statement,Object object) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int result = getSqlManager().update(statement, object);
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement);
        return result;
    }

    
    
    /*************************************                  공통                          ************************************/
    private void loggingElapsedTime(StopWatch stopWatch, String statement) {
         
        if (logger.isInfoEnabled()) {
            StringBuilder elapsedTime = new StringBuilder("Query [");
            elapsedTime.append(statement).append("] Elapsed Time : ");
            elapsedTime.append(stopWatch.getTotalTimeMillis()/1000f).append(" sec");
            logger.info(elapsedTime.toString());
        }
    }
    
    //TODO 원래대로라면 아래와 같이 SqlSessionDaoSupport에 있는 getSqlManager()을 사용하여야하지만 서로 연결이 안되어있으므로 우선은 위와 같이 autowired한 getSqlManager()를 사용한다.
/*  
    public <E> List<E> selectList(String statement, Params inParams) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        List<E> result = selectList(statement,inParams, new RowBounds(0, DEFAULT_MAXROWS + 1));
        stopWatch.stop();
        loggingElapsedTime(stopWatch, statement); 
        return result;
    }
*/    
    
    
    /*   아 아래소스는 트랜잭션 따로 처리를 위한 예제 소스이다. 몇가지 제약이 있는것 같지만.. 써야할 순간이 있을것 같기는 하다.
    public int deleteRequiresNew(String statement,Object obj) {
        return insertRequiresNew(statement,obj,  TRANSACTION_MANAGER);
    }
    
    public int deleteRequiresNew(final String statement, final Object obj, String transactionNm) {
        PlatformTransactionManager transactionManager = (PlatformTransactionManager) ParagonContextLoaderAdapter.getBean(transactionNm);
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return transactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus paramTransactionStatus) {
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                int cnt = SqlManager.this.delete(statement, obj);
                stopWatch.stop();
                SqlManager.this.loggingElapsedTime(stopWatch, statement);
                return cnt;
            }
        });
    }
    
    
    public int updateRequiresNew(String statement,Object obj) {
        return insertRequiresNew(statement,obj,  TRANSACTION_MANAGER);
    }
    
    public int updateRequiresNew(final String statement, final Object obj, String transactionNm) {
        PlatformTransactionManager transactionManager = (PlatformTransactionManager) ParagonContextLoaderAdapter.getBean(transactionNm);
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return transactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus paramTransactionStatus) {
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                int cnt = SqlManager.this.update(statement, obj);
                stopWatch.stop();
                SqlManager.this.loggingElapsedTime(stopWatch, statement);
                return cnt;
            }
        });
    }
    
    
    public int insertRequiresNew(String statement,Object obj) {
        return insertRequiresNew(statement,obj,  TRANSACTION_MANAGER);
    }
    
    public int insertRequiresNew(final String statement, final Object obj, String transactionNm) {
        PlatformTransactionManager transactionManager = (PlatformTransactionManager) ParagonContextLoaderAdapter.getBean(transactionNm);
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return transactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus paramTransactionStatus) {
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                int cnt = SqlManager.this.insert(statement, obj);
                stopWatch.stop();
                SqlManager.this.loggingElapsedTime(stopWatch, statement);
                return cnt;
            }
        });
    }  
    
    */  	
	
	
//	트랜잭션 분리를 위해서 해놓았던것이다.
//	@Autowired
//	ApplicationContext applicationContext;
//	public MyBatisTransactionManager getTransactionManager() {
//		return applicationContext.getBean(MyBatisTransactionManager.class);
//	}
	
}
