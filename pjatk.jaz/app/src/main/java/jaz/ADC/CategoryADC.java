package jaz.ADC;

import jaz.entity.CategoryEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CategoryADC
{
    List<CategoryEntity> getCategoryList();
    Optional<CategoryEntity> getCategoryById(Long categoryId);
    void save(CategoryEntity categoryEntity);
    void delete(CategoryEntity categoryEntity);
}
