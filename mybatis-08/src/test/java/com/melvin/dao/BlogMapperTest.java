package com.melvin.dao;

import com.melvin.pojo.Blog;
import com.melvin.utils.IDUtils;
import com.melvin.utils.MyBatisUtils;
import com.mysql.fabric.xmlrpc.base.Params;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogMapperTest {

    @Test
    public void addBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("今日笔记");
        blog.setAuthor("melvin");
        blog.setCreateTime(new Date());
        blog.setViews(11);
        mapper.addBlog(blog);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIf(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("title","mybatis如此简单");
        List<Blog> blogs = mapper.queryBlogIf(params);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("title","mybatis如此简单");
        params.put("views",11);

        List<Blog> blogs = mapper.queryBlogChoose(params);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("id","180cf49071cf4fad8c330f0290cf178a");
        params.put("title","明日笔记");
        int result = mapper.updateBlog(params);
        if (result > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,Object> params = new HashMap<String, Object>();
        List<String> ids = new ArrayList<String>();
        //ids.add("1");
        //ids.add("2");
        //ids.add("3");
        params.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(params);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
