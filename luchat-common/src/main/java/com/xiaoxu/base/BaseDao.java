package com.xiaoxu.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxu.exception.DBConcurrencyException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;


import javax.annotation.Resource;
import java.util.List;


/** 
 * @ClassName: BaseDao
 * @Description: 数据库操作基本实现类
		*/
public abstract class BaseDao{
	 @Resource
	    public SqlSessionTemplate sqlSession;

	    
		/**
		 * @param sqlSession the sqlSession to set
		 */
		public void setSqlSession(SqlSessionTemplate sqlSession) {
			this.sqlSession = sqlSession;
		} 
		/**
		 * @param statementName 名称
		 * @param entity 类
		 * @return Integer
		 */
		
		public Integer insert(String statementName, BaseEntity entity) {
			return sqlSession.insert(statementName, entity);
		}
		/**
		 * @param statementName 名称
		 * @param entity 类
		 * @return Integer
		 */
		
		public Integer insertForBatch(String statementName, BaseEntity entity) {
			return sqlSession.insert(statementName, entity);
		}


		/**
		 * @param statementName 名称
		 * @param entity 类
		 * @return Integer
		 */

		public Integer update(String statementName, BaseEntity entity){
			int updateCount = sqlSession.update(statementName, entity);
			if (updateCount == 0) {
				throw new DBConcurrencyException("该数据已发生改变，请重新刷新");
	        } else {
	            return updateCount;
	        }
		}

		/**
		 * 更新（不检查数据是否被改变）
		 * @param statementName 名称
		 * @param entity 类
		 * @return Integer
		 */

		public Integer updateNoDBConcurrency(String statementName, BaseEntity entity) {
	        return sqlSession.update(statementName, entity);
	    }
		/**
		 * 更新（不检查数据是否被改变）
		 * @param statementName 名称
		 * @param entity 类
		 * @return Integer
		 */

		public Object delete(String statementName, BaseEntity entity) {
			return sqlSession.delete(statementName, entity);
		}

		/**
		 * @param <T> ..
		 * @param statementName 名称
		 * @param obj 类
		 * @return <T>
		 * @throws RuntimeException 影响条数
		 */
		
		public <T> T selectOne(String statementName, Object obj) throws RuntimeException {
			try {
				return sqlSession.selectOne(statementName, obj);
			} catch (DataAccessException e) {
				throw new RuntimeException(e);
			}
		}
		/**
		 * @param statementName 名称
		 * @param param 参数
		 * @return int 
		 * @throws RuntimeException 
		 */
		
		public int count(String statementName, Object param) throws RuntimeException {
			try {
				return sqlSession.selectOne(statementName, param);
			} catch (DataAccessException e) {
				throw new RuntimeException(e);
			}
		}
		/**
		 * @param  <T> ..
		 * @param statementName 表名
		 * @return <T>
		 * @throws RuntimeException 影响数据
		 */
		
		public <T> List<T> select(String statementName) throws RuntimeException {
			try {
				return sqlSession.selectList(statementName);
			} catch (DataAccessException e) {
				throw new RuntimeException(e);
			}
		}
		/**
		 * @param <T> ..
		 * @param statementName 表名
		 * @param obj 类
		 * @return <T>
		 * @throws RuntimeException 影响数据
		 */
		
		public <T> List<T> select(String statementName, Object obj) throws RuntimeException {
			try {
				return sqlSession.selectList(statementName, obj);
			} catch (DataAccessException e) {
				throw new RuntimeException(e);
			}
		}

	/**
	 * 分页
	 * @param statementName 表名
	 * @param page
	 * @param <T>
	 * @return
	 */
		public <T> PageInfo<T> selectPage(String statementName, Page<T> page){
			PageHelper.startPage(page.getPageNo(), page.getPageSize());
			List<T> list = sqlSession.selectList(statementName, page.getParam());
			return new PageInfo<>(list);
		}
}
