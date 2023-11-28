package exercise.controller;

import java.util.List;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.mapper.ProductMapper;
import exercise.model.Category;
import exercise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    // BEGIN
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path = "")
    public List<ProductDTO> index() {
        var products = productRepository.findAll();
        return products.stream()
                .map(productMapper::map)
                .toList();
    }

    @GetMapping(path = "/{id}")
    public ProductDTO show(@PathVariable long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        var dto = productMapper.map(product);
        dto.setCategoryName(product.getCategory().getName());
        return dto;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@Valid @RequestBody ProductCreateDTO productData) throws NotFoundException {
        var product = productMapper.map(productData);
        Long categoryId = productData.getCategoryId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException());
        product.setCategory(category);
        productRepository.save(product);
        return productMapper.map(product);
    }

    @PutMapping(path = "/{id}")
    public ProductDTO update(@PathVariable long id, @RequestBody ProductUpdateDTO productData) throws NotFoundException {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        productMapper.update(productData, product);
        Long categoryId = productData.getCategoryId().get();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException());
        product.setCategory(category);
        productRepository.save(product);
        return productMapper.map(product);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        productRepository.delete(product);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Not Found")
    public class NotFoundException extends Exception {

        public NotFoundException() {
        }
    }
    // END
}
