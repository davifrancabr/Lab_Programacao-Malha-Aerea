package com.malha.ui;

import com.malha.application.dto.AirportDTO;
import com.malha.application.service.AirportService;
import com.malha.application.service.RouteService;
import com.malha.domain.repository.AirportRepository;
import com.malha.infrastructure.memory.InMemoryAirportRepository;
import com.malha.infrastructure.memory.InMemoryRouteRepository;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final AirportService airportService;
    private final RouteService routeService;

    private final Scanner scanner = new Scanner(System.in);
    public Menu(){
        var airportRepo = new InMemoryAirportRepository();
        var routeRepo = new InMemoryRouteRepository();
        this.airportService = new AirportService(airportRepo);
        this.routeService=new RouteService(routeRepo,airportRepo);

        airportService.createAirport("GRU", "SBGR", "Guarulhos International Airport", "São Pauslo", "Brasil");
        airportService.createAirport("GIG", "SBGL", "Tom Jobim - Galeão", "Rio de Janeiro", "Brasil");
        airportService.createAirport("BSB", "SBBR", "Brasilia International Airport", "Brasília", "Brasil");
        airportService.createAirport("MCZ", "SBMO", "Zumbi dos Palmares International Airport", "Maceió", "Brasil");
    }

    public static void main(String[] args) {
        new Menu().run();
    }

    private void run(){
        while(true){
            String option = scanner.nextLine().trim();
            try {
                switch (option) {
                    case "1":
                }
            }catch (Exception e){}
        }
    }

    private void printMenu(){
        System.out.println("n=== Malha Aérea - Menu ===");
        System.out.println("1) Criar aeroporto");
        System.out.println("2) Listar aeroportos");
        System.out.println("3) Atualizar aeroporto");
        System.out.println("4) Remover aeroporto");
        System.out.println("5) Criar rota");
        System.out.println("6) Listar rotas");
        System.out.println("7) Atualizar rota");
        System.out.println("8) Remover rota");
        System.out.println("9) Listar rotas por origem");
        System.out.println("0) Sair");
        System.out.print("Escolha: ");
    }

    private void createAirport(){
        System.out.print("Código IATA (ex.: GRU)");
        String code = scanner.nextLine().trim();
        System.out.print("Código ICAO (ex.: SBGR)");
        String code1 = scanner.nextLine().trim();
        System.out.print("Nome: ");
        String name = scanner.nextLine().trim();
        System.out.print("Cidade: ");
        String city = scanner.nextLine().trim();
        System.out.print("Pais: ");
        String country = scanner.nextLine().trim();
        AirportDTO dto = airportService.createAirport(code, code1, name, city,country);
        System.out.println(String.format("Criado: %s - %s(%s)", dto.id, dto.IcaoCode, dto.IataCode));
    }

    private void listAirports(){
        List<AirportDTO> list = airportService.listAllAirports();
        System.out.println("Aeroportos: ");
        list.forEach(a-> System.out.printf("%s | %s(%s) - %s, %s\n",
                a.id, a.IcaoCode, a.IataCode, a.name, a.city));
    }

    private void updateAirport(){
        System.out.print("ID do aeroporto: ");
        String id = scanner.nextLine().trim();

    }
}
