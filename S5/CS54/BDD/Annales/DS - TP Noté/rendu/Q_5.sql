SELECT * 
FROM station
WHERE alt_station > (SELECT AVG(alt_station)
                     FROM station);