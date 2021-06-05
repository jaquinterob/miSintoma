import React, { useState, useEffect } from "react";

const EditSintomaForm = ({ setEditing, currentSintoma, updateSintoma }) => {
  const [Sintoma, setSintoma] = useState(currentSintoma);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setSintoma({ ...sintoma, [name]: value });
  };

  useEffect(() => {
    setSintoma(currentSintoma);
  }, [currentSintoma]);

  return (
    <form
      onSubmit={(event) => {
        event.preventDefault();
        updateSintoma(sintoma.id, sintoma);
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
      <button onClick={() => setEditing(false)} className="button muted-button">
        Cancel
      </button>
    </form>
  );
};

export default EditSintomaForm;
