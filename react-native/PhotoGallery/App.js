/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import 'react-native-gesture-handler';
import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';
import type {Node} from 'react';
import React from 'react';
import DetailsScreen from './screens/DetailsScreen';
import PhotoListScreen from './screens/PhotoGridScreen';

const Root = createStackNavigator();

const App = (): Node => {
  return (
    <NavigationContainer>
      <Root.Navigator initialRouteName={'PhotoListScreen'}>
        <Root.Screen name="PhotoListScreen" component={PhotoListScreen} />
        <Root.Screen name="DetailsScreen" component={DetailsScreen} />
      </Root.Navigator>
    </NavigationContainer>
  );
};

export default App;
