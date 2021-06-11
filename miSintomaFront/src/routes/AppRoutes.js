import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Layout from "../containers/LayoutPrincipal/LayoutPrincipal";
import Home from "../components/home/Home";
import CovidVaccine from "../components/CovidVacinne/CovidVaccine";
import NotFound from "../components/notFound/NotFound";
import Sintoma from "../components/sintoma/Sintoma";
import localRoutes from "./localRoutes/localRoutes";

const AppRoutes = () => (
  <BrowserRouter>
    <Layout>
      <Switch>
        <Route exact path={localRoutes.BASE} component={Home} />
        <Route
          exact
          path={localRoutes.BASE + localRoutes.VACCINE}
          component={CovidVaccine}/>
        <Route
          exact
          path={localRoutes.BASE + localRoutes.SYMPTOM}
          component={Sintoma}
        />
        <Route component={NotFound} />
      </Switch>
    </Layout>
  </BrowserRouter>
);
export default AppRoutes;
