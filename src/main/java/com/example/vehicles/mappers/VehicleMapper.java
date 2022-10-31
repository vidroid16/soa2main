package com.example.vehicles.mappers;

import com.example.vehicles.dtos.CoordinatesDto;
import com.example.vehicles.dtos.VehicleDto;
import com.example.vehicles.dtos.VehicleToModifyDto;
import com.example.vehicles.models.Coordinates;
import com.example.vehicles.models.Enums.FuelType;
import com.example.vehicles.models.Enums.VehicleType;
import com.example.vehicles.models.Vehicle;

import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class VehicleMapper {
    public static Vehicle modifiedDtoToVehicle(VehicleToModifyDto dto){
        Vehicle vehicle = new Vehicle();
        vehicle.setName(dto.getName());
        vehicle.setMileage(dto.getMileage());
        vehicle.setEnginePower(dto.getEnginePower());
        vehicle.setFuelConsumption(dto.getFuelConsumption());
        vehicle.setType(VehicleType.valueOf(dto.getVehicleType()));
        vehicle.setFuelType(FuelType.valueOf(dto.getFuelType()));
        vehicle.setWheelsNumber(dto.getWheelsNumber());

        Coordinates coordinates = new Coordinates();
        coordinates.setX(dto.getCoordinates().getX());
        coordinates.setY(dto.getCoordinates().getY());

        vehicle.setCoordinates(coordinates);

        return vehicle;
    }

    public static VehicleDto vehicleToDto(Vehicle vehicle){
        VehicleDto dto = new VehicleDto();
        dto.setId(vehicle.getId());
        dto.setVehicleType(vehicle.getType().name());
        dto.setCreationDate(vehicle.getCreationDate().toString());
        dto.setMileage(vehicle.getMileage());
        dto.setEnginePower(vehicle.getEnginePower());
        dto.setName(vehicle.getName());
        dto.setWheelsNumber(vehicle.getWheelsNumber());
        dto.setFuelConsumption(vehicle.getFuelConsumption());
        dto.setFuelType(vehicle.getFuelType().name());

        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setX(vehicle.getCoordinates().getX());
        coordinatesDto.setY(vehicle.getCoordinates().getY());

        dto.setCoordinates(coordinatesDto);

        return dto;
    }
}
