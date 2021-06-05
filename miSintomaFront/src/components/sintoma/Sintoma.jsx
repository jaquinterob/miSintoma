import React, { useState, useEffect } from "react";
import "./Sintoma.scss";
import SintomaTable from "./SintomaTable";
import AddSintomaForm from "./AddSintomaForm";
import EditSintomaForm from "./EditSintomaForm";
import symptomData from "./utils/symptomData";
import service from "../../service/service";
import apiRoutes from "../../routes/apiRoutes/apiRoutes";

const Sintoma = () => {
  const [sintomas, setSintomas] = useState(symptomData);
  const [showLoading, setShowLoading] = useState(true);
  const [editing, setEditing] = useState(false);
  const [currentSintoma, setCurrentSintoma] = useState({
    id: null,
    namesintoma: "",
    descripcion: "",
  });

  useEffect(() => {
    const fetchData = async () => {
      const result = await service(
        apiRoutes.SYMPTOM_BASE + apiRoutes.SYMPTOM_ALL
      );
      setSintomas(result.data.sintomaList);
    };
    fetchData();
  }, []);

  const addSintoma = async ({ id, namesintoma, descripcion }) => {
    try {
      setShowLoading(true);
      const response = await service(
        apiRoutes.SYMPTOM_BASE + apiRoutes.SYMPTOM_ADD,
        "POST",
        { id, namesintoma, descripcion }
      );
      setSintomas([...sintomas, response.data]);
      setShowLoading(false);
    } catch (error) {
      setShowLoading(false);
      console.log(error);
    }
  };

  const deleteSintoma = async (id) => {
    try {
      setShowLoading(true);
      setSintomas(sintomas.filter((sintoma) => sintoma.id !== id));
      await service(apiRoutes.SYMPTOM_BASE + apiRoutes.SYMPTOM_REMOVE, "POST", {
        id,
      });
      setShowLoading(false);
    } catch (error) {
      setShowLoading(false);
      console.log(error);
    }
  };

  const editRow = ({ id, namesintoma, descripcion }) => {
    setEditing(true);
    setCurrentSintoma({
      id,
      namesintoma,
      descripcion,
    });
  };

  const updateSintoma = async (id, { namesintoma, descripcion }) => {
    try {
      setEditing(false);
      setShowLoading(true);
      setSintomas(
        sintomas.map((sintoma) =>
          sintoma.id === id
            ? {
                id,
                namesintoma,
                descripcion,
              }
            : sintoma
        )
      );
      await service(apiRoutes.SYMPTOM_BASE + apiRoutes.SYMPTOM_UPDATE, "POST", {
        id,
        namesintoma,
        descripcion,
      });
      setShowLoading(false);
    } catch (error) {
      setShowLoading(false);
      console.log(error);
    }
  };

  return (
    <div className="container">
      <h1>CRUD App with Hooks</h1>
      <div className="flex-row">
        <div className="flex-large">
          {editing ? (
            <>
              <h2>Edit Sintoma</h2>
              <EditSintomaForm
                setEditing={setEditing}
                currentSintoma={currentSintoma}
                updateSintoma={updateSintoma}
              />
            </>
          ) : (
            <>
              <h2>Add sintoma</h2>
              <AddSintomaForm addSintoma={addSintoma} />
            </>
          )}
        </div>

        <div className="flex-large">
          <h2>View Sintomas</h2>
          <SintomaTable
            sintomas={sintomas}
            deleteSintoma={deleteSintoma}
            editRow={editRow}
          />
        </div>
      </div>
    </div>
  );
};

export default Sintoma;
