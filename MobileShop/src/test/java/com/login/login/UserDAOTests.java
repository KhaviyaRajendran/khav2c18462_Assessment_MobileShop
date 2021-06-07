package com.login.login;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import com.login.login.dao.UserDAO;
import com.login.login.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserDAOTests {
	
    @Autowired
    private UserDAO userDao;
    
    @Autowired
    private TestEntityManager entityManager;
     
    @Test
    public void testCreateUser() {
        User user = new User();
        
        user.setEmail("kavin@gmail.com");
        user.setPassword("kavin20");
        user.setFirstName("Kavin");
        user.setLastName("Kumar");
         
        User savedUser = userDao.save(user);
         
        User existUser = entityManager.find(User.class, savedUser.getId());
         
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
      
      
    }
    
    @Test
    public void testFindUserByEmail() {
    	String email="kavin@gmail.com";
    	User user = userDao.findByEmail(email);
    	assertThat(user).isNotNull();
    }

}
