INSERT INTO routes (name, origin, destination, distance_km, estimated_duration_min, created_by)
VALUES
('Route 1', 'City A', 'City B', 100.50, 120, 'admin'),
('Route 2', 'City C', 'City D', 150.75, 180, 'admin');

INSERT INTO stops (route_id, name, stop_order, latitude, longitude, created_by)
VALUES
(1, 'Stop 1A', 1, 10.000001, -74.000001, 'admin'),
(1, 'Stop 1B', 2, 10.000002, -74.000002, 'admin'),
(2, 'Stop 2A', 1, 10.000003, -74.000003, 'admin');

INSERT INTO schedules (route_id, departure_time, arrival_time, days_of_week, created_by)
VALUES
(1, '08:00:00', '10:00:00', 'Monday to Friday', 'admin'),
(1, '18:00:00', '20:00:00', 'Monday to Friday', 'admin'),
(2, '09:00:00', '11:30:00', 'Saturday and Sunday', 'admin');