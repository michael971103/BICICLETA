package Services;


import Repository.BikeRepository;
import model.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAlL(){
        return (List<Bike>) bikeRepository.getAll();
    }
    public Optional<Bike> getBike(int id){
        return bikeRepository.getBike(id);
    }

    public Bike save(Bike bike){
        if(bike.getId()==null) {
            Optional<Bike> e = bikeRepository.getBike(bike.getId());
            if (e.isPresent()) {
                if (bike.getName() != null) {
                    e.get().setName(bike.getName());
                }
                if (bike.getBrand() != null) {
                    e.get().setBrand(bike.getBrand());
                }
                if (bike.getYear() != null) {
                    e.get().setYear(bike.getYear());
                }
                if (bike.getDescription() != null) {
                    e.get().setDescription(bike.getDescription());
                }
                bikeRepository.save(e.get());
                return e.get();
            } else {
                return bike;
            }
        }else{
            return bike;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Bike> p = bikeRepository.getBike(id);
        if(p.isPresent()){
            bikeRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}
