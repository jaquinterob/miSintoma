import React, { useState, useEffect } from "react";

const EditCovidVaccineForm = ({setEditing, currentCovidVaccine, updateCovidVaccine}) => {
  const [covidVaccine, setCovidVaccine] = useState(currentCovidVaccine);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setEmployee({ ...covidVaccine, [name]: value });
  };

  useEffect(() => {
    setEmployee(currentCovidVaccine);
  }, [props]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        updateCovidVaccine(covidVaccine.id, covidVaccine);
      }}
    >
      <label>Name Vaccine</label>
      <input
        type="text"
        name="nameVaccine"
        value={covidVaccine.nameVaccine}
        onChange={handleInputChange}
      />
      <label>Components</label>
      <input
        type="text"
        name="components"
        value={covidVaccine.components}
        onChange={handleInputChange}
      />

      <label>Laboratory</label>
      <input
        type="text"
        name="laboratory"
        value={covidVaccine.laboratory}
        onChange={handleInputChange}
      />

      <label>Expiration Date</label>
      <input
        type="text"
        name="expirationDate"
        value={covidVaccine.expirationDate}
        onChange={handleInputChange}
      />

      <label>clinicalData</label>
      <input
        type="text"
        name="clinicalData"
        value={covidVaccine.clinicalData}
        onChange={handleInputChange}
      />

      <label>Vaccine Batch</label>
      <input
        type="text"
        name="vaccineBatch"
        value={covidVaccine.vaccineBatch}
        onChange={handleInputChange}
      />

      <button>Update vaccine</button>
      <button
        onClick={() => setEditing(false)}
        className="button muted-button"
      >
        Cancel
      </button>
    </form>
  );
};

export default EditCovidVaccineForm;
