import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";

import Layout from "../containers/LayoutPrincipal/LayoutPrincipal";
import Home from "../components/home/Home";
import CovidVaccine from "../components/CovidVacinne/CovidVaccine";
import NotFound from "../components/notFound/NotFound";

const AppRoutes = () => (
  <BrowserRouter>
    <Layout>
      <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/covidVaccine" component={CovidVaccine} />
        <Route component={NotFound} />
      </Switch>
    </Layout>
  </BrowserRouter>
);

export default AppRoutes;
