import React, { useState } from "react";

const AddSintomaForm = (props) => {

const initialFormState = { id: null, namesintoma: "", descripcion: ""};
const [sintoma, setSintoma] = useState(initialFormState);

const handleInputChange = (event) => {
  const { name, value } = event.target;
        //console.log(event);
  setSintoma({ ...sintoma, [name]: value });
};

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        if (!sintoma.namesintoma || !sintoma.descripcion)
          return;

        props.addSintoma(sintoma);
        setSintoma(initialFormState);
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
