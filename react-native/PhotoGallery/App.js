/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, {useCallback, useEffect, useReducer} from 'react';
import {ActivityIndicator, StyleSheet, Text, View} from 'react-native';
import {getList} from './api/picsum';
import {actionCreators, initialState, reducer} from './reducers/photos';
import PhotoGrid from './components/PhotoGrid';
import type {Node} from 'react';

const App = (): Node => {
  const [state, dispatch] = useReducer(reducer, initialState);

  const {photos, nextPage, loading, error} = state;

  const fetchPhotos = useCallback(async () => {
    dispatch(actionCreators.loading());

    getList(nextPage)
      .then(nextPhotos =>
        dispatch(actionCreators.success(nextPhotos, nextPage)),
      )
      .catch(e => dispatch(actionCreators.failure()));
  }, [nextPage]);

  useEffect(() => {
    fetchPhotos();
  }, []);

  if (photos.length === 0) {
    if (loading) {
      return (
        <View style={styles.container}>
          <ActivityIndicator animating={true} />
        </View>
      );
    }

    if (error) {
      return (
        <View style={styles.container}>
          <Text>Something went wrong</Text>
        </View>
      );
    }
  }
  return (
    <PhotoGrid numColumns={3} photos={photos} onEndReached={fetchPhotos} />
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

export default App;
