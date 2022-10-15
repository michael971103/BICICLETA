package Services;


import Repository.CategoryRepository;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAlL(){
        return (List<Category>) categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category){
        if(category.getId()==null) {
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if (e.isPresent()) {
                if (category.getName() != null) {
                    e.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    e.get().setDescription(category.getDescription());
                }
                categoryRepository.save(e.get());
                return e.get();
            } else {
                return category;
            }
        }else{
            return category;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Category> p = categoryRepository.getCategory(id);
        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}
