import React, { useState } from "react";

const AddSintomaForm = ({ addSintoma }) => {
  const INITIAL_FORM_STATE = { id: null, namesintoma: "", descripcion: "" };
  const [sintoma, setSintoma] = useState(INITIAL_FORM_STATE);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setSintoma({ ...sintoma, [name]: value });
  };

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!sintoma.namesintoma || !sintoma.descripcion) return;
        addSintoma(sintoma);
        setSintoma(INITIAL_FORM_STATE);
      }}
    >
      <label>Name Sintoma</label>
      <input
        type="text"
        name="namesintoma"
        value={sintoma.namesintoma}
        onChange={handleInputChange}
      />
      <label>Descripcion</label>
      <input
        type="text"
        name="descripcion"
        value={sintoma.descripcion}
        onChange={handleInputChange}
      />

      <button>Add new sintoma</button>
    </form>
  );
};
export default AddSintomaForm;
