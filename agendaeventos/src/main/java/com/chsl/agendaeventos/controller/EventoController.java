package com.chsl.agendaeventos.controller;

import com.chsl.agendaeventos.model.Evento;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
//@RequestMapping("/eventos")
public class EventoController {

//    @Autowired
//    EventoRepository eventoRepository;


    private Map<Integer, Evento> eventoMap;
    private Integer proximoId = 1;


    public EventoController() {
        eventoMap = new HashMap<>();

        Evento e1 = new Evento(1, "Workshop ReactJs", "Estudar framework para front","25/10/2018 19:00","26/10/2018 23:59");
        Evento e2 = new Evento(2, "Workshop Spring Data", "Adicionar MongoDB no projeto", "27/10/2018 19:00","28/10/2018 23:59");
        Evento e3 = new Evento(3, "Desenvolvimento mobile Ionic", "Entrar no mundo híbrido","29/10/2018 19:00","28/11/2018 23:59");

        eventoMap.put(1, e1);
        eventoMap.put(2, e2);
        eventoMap.put(3, e3);
    }

//    private Evento cadastrar(Evento evento){
//        if (eventoMap == null){
//            eventoMap = new HashMap<>();
//        }
//        evento.setId(proximoId);
//
//        proximoId++;
//
//        eventoMap.put(evento.getId(),evento);
//
//        return evento;
//    }
//
//
//    @RequestMapping(value="/cadastrarEvento", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Evento> cadastrarEvento(@RequestBody  Evento evento){
//
//        Evento eventoCadastrado = cadastrar(evento);
//        return new ResponseEntity<>(eventoCadastrado, HttpStatus.CREATED);
//    }



    @RequestMapping(value = "/eventos", method = RequestMethod.GET)
    public ResponseEntity<List<Evento>> listar() {
        return new ResponseEntity<List<Evento>>(new ArrayList<Evento>(eventoMap.values()), HttpStatus.OK);
    }

    @RequestMapping(value = "/eventos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Evento> buscar(@PathVariable("id") Integer id) {
        Evento evento = eventoMap.get(id);

        if (evento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Evento>(evento, HttpStatus.OK);
    }

    @RequestMapping(value = "/eventos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletar(@PathVariable("id") int id) {
        Evento evento = eventoMap.remove(id);

        if (evento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @RequestMapping(method= RequestMethod.GET, value="/")
//    public Iterable<Evento> listarEventos() {
//        return eventoMap.findAll();
//    }
//
//    @RequestMapping(method=RequestMethod.POST, value="/")
//    public Evento criarEvento(@RequestBody Evento evento) {
//        eventoRepository.save(evento);
//
//        return evento;
//    }
//
//    @RequestMapping(method=RequestMethod.GET, value="/{id}")
//    public Optional<Evento> exibirById(@PathVariable String id) {
//        return eventoRepository.findById(id);
//    }
//
//    @RequestMapping(method=RequestMethod.PUT, value="{id}")
//    public Evento atualizar(@PathVariable String id, @RequestBody Evento evento) {
//        Optional<Evento> optEvento = eventoRepository.findById(id);
//        Evento e = optEvento.get();
//        if(evento.getNome() != null)
//            e.setNome(evento.getNome());
//        if(evento.getDescricao() != null)
//            e.setDescricao(evento.getDescricao());
//        if(evento.getDataInicio() != null)
//            e.setDataInicio(evento.getDataInicio());
//        if(evento.getDataFim() != null)
//            e.setDataFim(evento.getDataFim());
//
//        eventoRepository.save(e);
//        return e;
//    }
//
//    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
//    public String deletar(@PathVariable String id) {
//        Optional<Evento> optEvento = eventoRepository.findById(id);
//        Evento evento = optEvento.get();
//        eventoRepository.delete(evento);
//
//        return "";
//    }
}
