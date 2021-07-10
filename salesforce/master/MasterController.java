package pe.kr.deity.salesforce.master;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;



import java.util.List;
@Slf4j
public abstract class MasterController<M,ID> {

    @Autowired(required = false)
    private JpaRepository<M, ID> repository;

    @GetMapping("/{id}")
    public M get(@PathVariable ID id){
        log.info("get :"+id);
        return repository.findById(id).get();
    }

    //페이징은 필요하다...
    //조건식 있는것도 필요한데?
    @GetMapping
    public List<M> list(){
        log.info("list");
        return repository.findAll();
    }

    @PostMapping
    public M create(@RequestBody M m){
        log.info("create");

        M created = repository.save(m);
        return created;
    }

    @PutMapping("/{id}")
    public M update(@RequestBody M m){
        log.info("update");
        M updated = repository.save(m);
        return updated;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable ID id) {
        log.debug("GenericController.delete - {}",id);
        repository.deleteById(id);
        return true;
    }

}
