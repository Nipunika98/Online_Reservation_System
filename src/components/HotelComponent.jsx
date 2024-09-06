import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import {
  Card,
  CardBody,
  CardTitle,
  CardSubtitle,
  Button,
  Container,
  Row,
  Col,
} from "reactstrap";

const HotelComponent = () => {
  const [hotels, setHotels] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios
      .get("http://localhost:8086/api/hotels")
      .then((response) => {
        setHotels(response.data);
        console.log(response);
      })
      .catch((error) => {
        console.error("Error fetching hotels:", error);
      });
  }, []);

  const handleMenuClick = (hotel) => {
    navigate("/menu", { state: { hotel } });
  };

  return (
    <Container>
      <Row>
        {hotels.map((hotel) => (
          <Col key={hotel.name} sm="3">
            <Card>
              <CardBody>
                {hotel.imageName && (
                  <img
                    src={hotel.imageName} // Directly using the base64 image string
                    alt={hotel.name}
                    style={{ height: "200px", maxWidth: "100%", objectFit: "cover" }}
                  />
                )}
                <CardTitle tag="h5">{hotel.name}</CardTitle>
                <CardSubtitle>{hotel.location}</CardSubtitle>
                <p>Ratings: {hotel.ratings}</p>
                <p>Capacity: {hotel.capacity}</p>
                <p>Status: {hotel.status ? "Open" : "Closed"}</p>
              </CardBody>
              <Button
                color="primary"
                onClick={() => handleMenuClick(hotel)}
              >
                Click Here
              </Button>
            </Card>
          </Col>
        ))}
      </Row>
    </Container>
  );
};

export default HotelComponent;
