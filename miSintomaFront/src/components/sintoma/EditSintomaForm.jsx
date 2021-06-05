import React, { useState, useEffect } from "react";

const EditSintomaForm = (props) => {
  const [Sintoma, setSintoma] = useState(props.currentSintoma);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setSintoma({ ...sintoma, [name]: value });
  };

  useEffect(() => {
    setSintoma(props.currentSintoma);
  }, [props]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        props.updateSintoma(sintoma.id, sintoma);
      }}
    >
      <label>Name Sintoma</label>
      <input
        type="text"
        name="namesintoma"
        value={sintoma.namesintoma}
        onChange={handleInputChange}
      />
      <label>descripcion</label>
      <input
        type="text"
        name="descripcion"
        value={sintoma.descripcion}
        onChange={handleInputChange}
      />

      <button>Update sintoma</button>
      <button
        onClick={() => props.setEditing(false)}
        className="button muted-button"
      >
        Cancel
      </button>
    </form>
  );
};

export default EditSintomaForm;
