package com.bing.myblog;

import com.bing.myblog.config.MyShiroRealm;
import com.bing.myblog.entity.Article;
import com.bing.myblog.entity.Comment;
import com.bing.myblog.entity.UserInfo;
import com.bing.myblog.servics.ArticleService;
import com.bing.myblog.servics.CommentService;
import com.bing.myblog.servics.LoginService;
import com.bing.myblog.util.GenerateSalt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyblogApplicationTests {
	@Autowired
	//ArticleService articleService;
	LoginService loginService;
	//CommentService commentService;

	@Test
	public void contextLoads() {

		//测试articleService.getById(int id);
		//Article article = articleService.getById(1);
		//System.out.println(article.getCreateDate());

		/*测试articleService.getAll();
		List<Article> listArticle = articleService.getAll();
		Iterator<Article> it = listArticle.iterator();
		while (it.hasNext()) {
			Article article = it.next();
			System.out.println(article.getTitle());
			Date date = article.getCreateDate();
			//System.out.println(date.getTime());
			DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
			System.out.println(fullDateFormat.format(date.getTime()));

		}
		*/

		/*测试articleService.addArticle(Article article);
		Article article = new Article();
		Calendar calendar=Calendar.getInstance();
		calendar.set(2015, 10, 12);
		Date date=calendar.getTime();
		article.setModifyDate(date);
		article.setTitle("title9");
		System.out.println(articleService.addArticle(article));
		*/

		//System.out.println(articleService.deleteArticle(5));

		/*
		Article article = new Article();
		article.setId(1);
		article.setTitle("title1-1");
		Calendar calendar=Calendar.getInstance();
		Date date=calendar.getTime();
		article.setModifyDate(date);
		System.out.println(articleService.updateArticle(article));
		*/

		/*密码加盐加密操作
		UserInfo userInfo = loginService.getByUserName("admin");
		System.out.println(userInfo.getPermissions());
		String string=new Md5Hash("123456","9TAYiq1R2Z").toHex();
		System.out.println(string);
		String constantString = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		System.out.println(constantString.length());
		System.out.println(new Md5Hash("123456","123456"+"9TAYiq1R2Z").toHex());
		System.out.println(new Md5Hash("123456","123456"+"g7ycGhgFeX").toHex());
		*/

		/*测试CommentService
		List<Comment> comments=commentService.getByArticleId(3);
		Iterator<Comment> it = comments.iterator();
		while (it.hasNext()) {
			Comment comment = it.next();
			System.out.println(comment.getCommentDetail());
			System.out.println(comment.getId());
		}
		*/



	}
	/*
	SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
	@Before
	public void addUser(){
		simpleAccountRealm.addAccount("Mark", "123456", "admin");
	}
	@Test
	public void testAuthenticationTest(){
		//构建SecurityManager环境
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(simpleAccountRealm);

		//主体提交认证请求
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
		subject.login(token);
		System.out.println("isAuthenticated:"+subject.isAuthenticated());
		subject.checkRole("admin");
	}
	*/
}
