package kitchenpos.application;

import kitchenpos.dao.ProductDao;
import kitchenpos.domain.Product;
import kitchenpos.domain.ProductRepository;
import kitchenpos.dto.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public ProductResponse create(final Product productRequest) {
        Product product = new Product(productRequest.getId(), productRequest.getName(), productRequest.getPrice());
        product.validationCheck();
        productRepository.save(product);
        return ProductResponse.of(product);
    }

    public List<Product> list() {
        return productRepository.findAll();
    }
}
