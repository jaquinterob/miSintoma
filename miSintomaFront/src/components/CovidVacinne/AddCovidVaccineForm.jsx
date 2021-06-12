import React, { useState } from "react";

const AddCovidVaccineForm = ({ addCovidVaccine }) => {
  const INITIAL_FORM_STATE = {
    id: null,
    nameVaccine: "",
    components: "",
    laboratory: "",
    expirationDate: "",
    clincialData: "",
    vaccineBatch: "",
  };
  const [covidVaccine, setCovidVaccine] = useState(INITIAL_FORM_STATE);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setEmployee({ ...covidVaccine, [name]: value });
  };

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (
          !covidVaccine.nameVaccine ||
          !covidVaccine.components ||
          !covidVaccine.laboratory ||
          !covidVaccine.expirationDate ||
          !covidVaccine.clincialData ||
          !covidVaccine.vaccineBatch
        )
          return;

        addCovidVaccine(covidVaccine);
        setCovidVaccine(INITIAL_FORM_STATE);
      }}
    >
      <label>Name Vaccine</label>
      <input
        type="text"
        name="NameVaccine"
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
        name="Laboratory"
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

      <label>Clincial Data</label>
      <input
        type="text"
        name="clinicalData"
        value={covidVaccine.clincialData}
        onChange={handleInputChange}
      />

      <label>Vaccine Batch</label>
      <input
        type="text"
        name="vaccineBatch"
        value={covidVaccine.vaccineBatch}
        onChange={handleInputChange}
      />

      <button>Add new vaccine</button>
    </form>
  );
};
export default AddCovidVaccineForm;
