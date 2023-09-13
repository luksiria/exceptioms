import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepoTest {


    @Test
    public void RemoveProductInList() {
        Repo repo = new Repo();
        Product product1 = new Product(1, "молоко", 50);
        Product product2 = new Product(2, "книга", 1000);
        Product product3 = new Product(3, "тв", 50000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
            }

    @Test
    public void RemoveProductNotInList() {
        Repo repo = new Repo();
        Product product1 = new Product(1, "молоко", 50);
        Product product2 = new Product(2, "книга", 1000);
        Product product3 = new Product(3, "тв", 50000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
        () -> repo.remove(12)
        );
    }
}
