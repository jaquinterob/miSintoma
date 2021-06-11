import React, { useState, useEffect } from "react";
import axios from "axios";

const GetGreeting = () => {
  const apiUrl = "http://localhost:8282/";

  //const GreetingData = [{ id: 1, content: "Sin Contenido" }];
  const [greeting, setGreeting] = useState(null);
  const [showLoading, setShowLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios(apiUrl + "greeting");
      console.log(result)
      setGreeting(result.data.content);
    };
    fetchData();
  }, []);

  return (
    <div className={"container"}>
      <h1>{greeting}</h1>
    </div>
  );
};

export default GetGreeting;
