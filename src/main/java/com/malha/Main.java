package com.malha;


import com.malha.application.dto.AircraftDTO;
import com.malha.application.dto.AirportDTO;
import com.malha.application.dto.RouteDTO;
import com.malha.application.service.AircraftService;
import com.malha.application.service.AirportService;
import com.malha.application.service.RouteService;
import com.malha.infrastructure.memory.InMemoryAircraftRepository;
import com.malha.infrastructure.memory.InMemoryAirportRepository;
import com.malha.infrastructure.memory.InMemoryRouteRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final AirportService airportService;
    private final RouteService routeService;
    private final AircraftService aircraftService;

    private final Scanner scanner = new Scanner(System.in);

    public Main() {
        var airportRepo = new InMemoryAirportRepository();
        var routeRepo = new InMemoryRouteRepository();
        var aircraftRepo = new InMemoryAircraftRepository();
        this.airportService = new AirportService(airportRepo);
        this.routeService=new RouteService(routeRepo,airportRepo);
        this.aircraftService=new AircraftService(aircraftRepo);

        airportService.createAirport("GRU", "Guarulhos International Airport", "São Paulo", "Brasil");

        aircraftService.create("Boeing 737-800");
        aircraftService.create("Airbus A320neo");

    }

    public static void main(String[] args) {
        new Main().run();
    }
    private void run(){
        while(true){
            printMenu();
            String option = scanner.nextLine().trim();
            try {
                switch (option) {
                    case "1": createAirport(); break;
                    case "2": listAirports(); break;
                    case "3": updateAirport(); break;
                    case "4": deleteAirport(); break;
                    case "5": createRoute(); break;
                    case "6": listRoutes(); break;
                    case "7": updateRoute(); break;
                    case "8": deleteRoute(); break;
                    case "9": listRoutesByOrigin(); break;
                    case "10": createAircraft(); break;
                    case "11": listAircrafts(); break;
                    case "12": updateAircraft(); break;
                    case "13": deleteAircraft(); break;
                    case "0": System.out.println("Saindo..."); return;
                    default: System.out.println("Opção inválida");
                }
            }catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
            System.out.println("\n--- Enter para continuar ---");
            scanner.nextLine();
        }
    }

    private void printMenu(){
        System.out.println("\n=== Malha Aérea - Menu ===");
        System.out.println("1) Criar aeroporto");
        System.out.println("2) Listar aeroportos");
        System.out.println("3) Atualizar aeroporto");
        System.out.println("4) Deletar aeroporto");
        System.out.println("5) Criar rota");
        System.out.println("6) Listar rotas");
        System.out.println("7) Atualizar rota");
        System.out.println("8) Deletar rota");
        System.out.println("9) Listar rotas por origem");
        System.out.println("--- Tipos de Aeronave ---");
        System.out.println("10) Criar tipo de aeronave");
        System.out.println("11) Listar tipos de aeronave");
        System.out.println("12) Atualizar tipo de aeronave");
        System.out.println("13) Deletar tipo de aeronave");
        System.out.println("0) Sair");
        System.out.print("Escolha: ");
    }

    private void createAirport(){
        System.out.print("IATA (3 letras): ");
        String code = scanner.nextLine().trim();

        System.out.print("Nome: ");
        String name = scanner.nextLine().trim();
        System.out.print("Cidade: ");
        String city = scanner.nextLine().trim();
        System.out.print("País: ");
        String country = scanner.nextLine().trim();
        AirportDTO dto = airportService.createAirport(code, name, city, country);
        System.out.printf("Criado: %s - IATA: %s", dto.id, dto.code);
    }

    private void listAirports(){
        List<AirportDTO> list = airportService.listAllAirports();
        System.out.println("Aeroportos: ");
        list.forEach(a-> System.out.printf("%s | IATA:%s - %s - %s, %s\n",
                a.id, a.code, a.name, a.city, a.country));
    }

    private void listAirportsSimple(){
        airportService.listAllAirports().forEach(a-> System.out.printf("%s | IATA:%s | %s, %s\n",
                a.id, a.code, a.name, a.city));
    }

    private void updateAirport(){
        System.out.print("ID do aeroporto: ");
        String id = scanner.nextLine().trim();
        System.out.print("Novo IATA (3 letras): ");
        String code = scanner.nextLine().trim();
        System.out.print("Novo nome: ");
        String name = scanner.nextLine().trim();
        System.out.print("Nova cidade: ");
        String city = scanner.nextLine().trim();
        System.out.print("Novo país: ");
        String country = scanner.nextLine().trim();
        AirportDTO dto = airportService.updateAirport(id, code, name, city, country);
        System.out.println("Atualizado: " + dto.id);
    }

    private void deleteAirport() {
        System.out.print("ID do aeroporto a deletar: ");
        String id = scanner.nextLine().trim();
        airportService.deleteAirport(id);
        System.out.println("Deletado: " + id);
    }

    private void createRoute() {
        System.out.print("ID do aeroporto origem: ");
        String origin = scanner.nextLine().trim();
        System.out.print("ID do aeroporto destino: ");
        String dest = scanner.nextLine().trim();
        System.out.print("Distância (km): ");
        double km = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Tempo estimado (min): ");
        int min = Integer.parseInt(scanner.nextLine().trim());
        RouteDTO dto = routeService.createRoute(origin, dest, km, min);
        System.out.println("Rota criada: " + dto.id);
    }

    private void listRoutes() {
        List<RouteDTO> list = routeService.listAll();
        System.out.println("Rotas:");
        list.forEach(r -> System.out.printf("%s | %s -> %s | %.1f km | %d min\n",
                r.id, r.originAirportId, r.destinationAirportId, r.distanceKm, r.estimatedMinutes));
    }

    private void updateRoute() {
        System.out.print("ID da rota: ");
        String id = scanner.nextLine().trim();
        System.out.print("Nova distância (km): ");
        double km = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Novo tempo estimado (min): ");
        int min = Integer.parseInt(scanner.nextLine().trim());
        RouteDTO dto = routeService.updateRoute(id, km, min);
        System.out.println("Rota atualizada: " + dto.id);
    }

    private void deleteRoute() {
        System.out.print("ID da rota a deletar: ");
        String id = scanner.nextLine().trim();
        routeService.deleteRoute(id);
        System.out.println("Rota deletada: " + id);
    }

    private void listRoutesByOrigin() {
        System.out.print("ID aeroporto origem: ");
        String origin = scanner.nextLine().trim();
        List<RouteDTO> routes = routeService.listRoutesByOrigin(origin);
        if (routes.isEmpty()) {
            System.out.println("Nenhuma rota encontrada para esse aeroporto.");
        } else {
            routes.forEach(r -> System.out.printf("%s | %s -> %s | %.1f km | %d min\n",
                    r.id, r.originAirportId, r.destinationAirportId, r.distanceKm, r.estimatedMinutes));
        }
    }

    private void createAircraft() {
        System.out.print("Nome do tipo de aeronave (ex: Boeing 737-800): ");
        String name = scanner.nextLine().trim();
        AircraftDTO dto = aircraftService.create(name);
        System.out.println("Criado: " + dto.id + " - " + dto.name);
    }

    private void listAircrafts() {
        List<AircraftDTO> list = aircraftService.listAll();
        System.out.println("Tipos de aeronave:");
        list.forEach(a -> System.out.printf("%s | %s\n", a.id, a.name));
    }

    private void updateAircraft() {
        System.out.print("ID do tipo de aeronave: ");
        String id = scanner.nextLine().trim();
        System.out.print("Novo nome: ");
        String name = scanner.nextLine().trim();
        AircraftDTO dto = aircraftService.update(id, name);
        System.out.println("Atualizado: " + dto.id);
    }

    private void deleteAircraft() {
        System.out.print("ID do tipo de aeronave a deletar: ");
        String id = scanner.nextLine().trim();
        aircraftService.delete(id);
        System.out.println("Deletado: " + id);
    }
}