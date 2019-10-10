import com.Application;
import com.dao.CategoryDao;
import com.entity.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class DaoTest {
    @Autowired
    private CategoryDao categoryDao;
    @Test
    public void TestCategoryDao(){
    categoryDao.findAll();

    }
}
