package Repository;

import Repository.CrudRepository.ReservationCrudRepository;
import model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//author michael971103
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getById(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
}
