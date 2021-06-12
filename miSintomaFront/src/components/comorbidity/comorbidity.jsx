import React, { useState } from "react";
import { data as COMORBIDITY_DATA } from "./utils/comorbidityBaseData";
import AddComorbidity from "./addComorbidity";
import EditComorbidity from "./editComorbidity";
import styles from "./comorbidity.module.scss";

export default function Comorbidity() {
  const [comorbidities, setComorbidities] = useState(COMORBIDITY_DATA);

  const handlerCreate = (newComorbidity) => {
    const newComorbidities = [...comorbidities];
    newComorbidities.push(newComorbidity);
    setComorbidities(newComorbidities);
  };

  return (
    <>
      <div className={styles.title}>
        <h1>Comorbidilidades</h1>
      </div>
      <div className={styles.components}>
        <AddComorbidity handlerCreate={handlerCreate} />
        <EditComorbidity
          comorbidities={comorbidities}
          setComorbidities={setComorbidities}
        />
      </div>
    </>
  );
}
